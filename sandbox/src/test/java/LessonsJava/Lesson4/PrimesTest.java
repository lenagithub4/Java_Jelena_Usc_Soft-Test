package LessonsJava.Lesson4;

import lessonsJava.Lesson4.Primes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTest {

    @Test
    public void testPrimes() {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));

    }

    @Test
    public void testNonPrimes() {
        Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE-2));

    }

    @Test (enabled = false)
    public void testPrimesLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));

    }

}



