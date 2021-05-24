package com.company;
import java.io.Serializable;

public class MyException extends Exception implements Serializable{
        public MyException() { }
        public MyException(String message)
        {
            super(message);
        }
        public MyException(String message, Throwable cause)
        {
            super(message, cause);
        }
        public MyException(Throwable cause)
        {
            super(cause);
        }
}

