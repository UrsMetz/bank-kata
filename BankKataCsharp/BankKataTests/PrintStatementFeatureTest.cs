using BankKata;
using Moq;
using Xunit;

namespace BankKataTests
{
    public class PrintStatementFeatureTest
    {
        [Fact]
        public void PrintsRunningBalanceOfAllTransactions()
        {
            var consoleMock = new Mock<IConsole>();

            var account = new Account();
            account.Deposite(1000);
            account.Withdraw(100);
            account.Deposite(400);

            account.PrintStatement();

            consoleMock.Verify(x => x.PrintLine("DATE | AMOUNT | BALANCE"));
            consoleMock.Verify(x => x.PrintLine("10/04/2014 | 500.00 | 1400.00"));
            consoleMock.Verify(x => x.PrintLine("02/04/2014 | -100.00| 900.00"));
            consoleMock.Verify(x => x.PrintLine("01/04/2014 | 1000.00| 1000.00"));
        }
    }
}