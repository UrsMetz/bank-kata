using BankKata;
using Moq;
using Xunit;

namespace BankKataTests
{
    public class PrintStatementFeatureTest
    {
        private readonly Mock<IConsole> _consoleMock;
        private readonly Account _account;

        public PrintStatementFeatureTest()
        {
            _consoleMock = new Mock<IConsole>();
            _account = new Account();
        }

        [Fact]
        public void PrintsRunningBalanceOfAllTransactions()
        {
            _account.Deposite(1000);
            _account.Withdraw(100);
            _account.Deposite(400);

            _account.PrintStatement();

            _consoleMock.Verify(x => x.PrintLine("DATE | AMOUNT | BALANCE"));
            _consoleMock.Verify(x => x.PrintLine("10/04/2014 | 500.00 | 1400.00"));
            _consoleMock.Verify(x => x.PrintLine("02/04/2014 | -100.00| 900.00"));
            _consoleMock.Verify(x => x.PrintLine("01/04/2014 | 1000.00| 1000.00"));
        }
    }
}