using System.Collections.Generic;
using BankKata;
using Moq;
using Xunit;

namespace BankKataTests
{
    public class PrintStatementFeatureTest
    {
        private readonly Mock<IConsole> _consoleMock;
        private readonly Account _account;

        private readonly IList<string> _printedConsoleStatements;

        public PrintStatementFeatureTest()
        {
            // Moq hat leider keine (elegante) Möglichkeit die Reihenfolge von Aufrufen zu prüfen,
            // daher machen wir das "zu Fuß"
            _printedConsoleStatements = new List<string>();

            _consoleMock = new Mock<IConsole>(MockBehavior.Strict);
            _consoleMock.Setup(x => x.PrintLine(It.IsAny<string>()))
                .Callback((string text) => _printedConsoleStatements.Add(text));

            _account = new Account();
        }

        [Fact]
        public void PrintsRunningBalanceOfAllTransactions()
        {
            _account.Deposite(1000);
            _account.Withdraw(100);
            _account.Deposite(500);

            _account.PrintStatement();

            Assert.Equal(new[]
            {
                "DATE | AMOUNT | BALANCE",
                "10/04/2014 | 500.00 | 1400.00",
                "02/04/2014 | -100.00 | 900.00",
                "01/04/2014 | 1000.00 | 1000.00"
            }, _printedConsoleStatements);
        }
    }
}
