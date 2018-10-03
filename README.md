# Bank kata

A kata for practising TDD outside-in, inspired by Sandro Macuso [[2]], see also [[3]].

## Starting point and constraints

1. Start with a class implementing the Account interface

    ```
    public class Account {

      public void deposit(int amount) {}

      public void withdraw(int amount) {}

      public void printStatement() {}

    }
    ```

2. You may not change the interface and may not add other public methods to this class
3. Keep it simple: Use Strings for dates and integers for amounts
4. Don't worry about spacing in the statement printed to the console

## Acceptance criterion

Your task is to implement the following functionality:

* Upon a user request, a statement of all the deposit or withdrawal transactions made to the account is printed to the console.
* The transactions are listed in reverse chronological order.
* A running balance of the account is printed along with each transaction.

**Example:**
```
DATE       | AMOUNT  | BALANCE
10/04/2014 |  500.00 | 1400.00
02/04/2014 | -100.00 |  900.00
01/04/2014 | 1000.00 | 1000.00
```

## TDD outside-in

TDD outside-in starts with a failing acceptance test. You then fill in the missing functionality using TDD with unit tests. This creates an implementation flow from the outside towards the interior, in contrast to classic TDD, where you usually start in the interior. TDD outside-in thus focuses more on objects and their interactions - the messages they send to each other instead of asserting the state of objects.

### IDE Configuration
Configure your IDE so that a newly created method has as body

```
throw new UnsupportedOperationException("not implemented yet");
```

This will help you find the next spot, where an implementation is still missing.

### Make the diagnostics clear

After writing a failing test (in particular, a failing acceptance test), we must make sure that it fails for the right reason. This is called "Make the diagnostics clear" in [1] and inserts itself as an additional step to the TDD cycle between "write a failing test" and "make it pass".

---

## References

* [1]: Steve Freeman, Nat Pryce, Growing Object-Oriented Software, Guided by Tests

* [2] [Bank kata by Sandro Macuso][2]   
  [2]: https://github.com/sandromancuso/Bank-kata
  
* [3]  [Kata-log][3]  
  [3]: http://kata-log.rocks/banking-kata
