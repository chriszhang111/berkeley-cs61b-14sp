/**
 *  Implements an exception that should be thrown for invalid transaction amount (e.g. negative).
 **/

public class BadTransactionException extends Exception {

  private int transAmt;  // The invalid transaction amount.

  /**
   *  Creates an exception object for invalid transaction amount "badTransAmt".
   **/
  public BadTransactionException(int badTransAmt) {
    super("Invalid transaction amount: " + badTransAmt);

    transAmt = badTransAmt;
  }
}