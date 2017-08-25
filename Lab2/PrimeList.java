package Lab2;

import java.math.BigInteger;
import java.util.ArrayList;

public class PrimeList implements Runnable {

	private ArrayList<BigInteger> primesFound;
	private int numOfPrimes, numOfDigits;
	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = new BigInteger("2");
	public BigInteger start;
	public BigInteger finish;

	private static final int VAL = 100;

	public PrimeList(int numOfPrimes, int numOfDigits, boolean run) {

		primesFound = new ArrayList<BigInteger>(numOfPrimes);

		this.numOfPrimes = numOfPrimes;
		this.numOfDigits = numOfDigits;
		if (run) {
			Thread t = new Thread(this);
			t.setPriority(Thread.MIN_PRIORITY);
			t.start();
		} else {
			run();
		}
	}

	public PrimeList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		BigInteger myPrime = getPrime(numOfDigits);
		start = myPrime;
		// System.out.println("1 myPrime BigInt is: " + myPrime);
		for (int i = 0; i < numOfPrimes; i++) {
			myPrime = nextPrime(myPrime);
			synchronized (this) {
				primesFound.add(myPrime);
			}
		}
		finish = myPrime;
		// System.out.println("myLastPrime: " + getFinish());
		// int diff = finish.intValue() - start.intValue();
		// System.out.println("2 myPrime BigInt is: " + myPrime);
		// System.out.println("the diff: " + diff);
	}

	private BigInteger nextPrime(BigInteger myPrime) {

		if (isEven(myPrime))
			myPrime = myPrime.add(ONE);
		else
			myPrime = myPrime.add(TWO);
		if (myPrime.isProbablePrime(VAL))
			return myPrime;
		else
			return nextPrime(myPrime);
	}

	private boolean isEven(BigInteger myPrime) {
		return myPrime.mod(TWO).equals(ZERO);
	}

	private BigInteger getPrime(int numOfDigits2) {
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i < numOfDigits; i++) {
			if (i == 0) {
				s.append(randomDigit(false));
			} else {
				s.append(randomDigit(true));
			}
		}
		return new BigInteger(s.toString());
	}

	private static StringBuffer[] digits = { new StringBuffer("0"), new StringBuffer("1"), new StringBuffer("2"),
			new StringBuffer("3"), new StringBuffer("4"), new StringBuffer("5"), new StringBuffer("6"),
			new StringBuffer("7"), new StringBuffer("8"), new StringBuffer("9") };

	private Object randomDigit(boolean b) {
		int index;
		if (b) {
			index = (int) Math.floor(Math.random() * 10);
		} else {
			index = 1 + (int) Math.floor(Math.random() * 9);
		}
		return digits[index];
	}

	@SuppressWarnings("unchecked")
	public synchronized ArrayList<BigInteger> getPrimes() {
		if (isDone())
			return primesFound;
		else
			return (ArrayList<BigInteger>) primesFound.clone();
	}

	private boolean isDone() {
		return primesFound.size() == numOfPrimes;
	}

	public int getNumOfPrimes() {
		return numOfPrimes;
	}

	public void setNumOfPrimes(int numOfPrimes) {
		this.numOfPrimes = numOfPrimes;
	}

	public int getNumOfDigits() {
		return numOfDigits;
	}

	public void setNumOfDigits(int numOfDigits) {
		this.numOfDigits = numOfDigits;
	}

	public BigInteger getStart() {
		return start;
	}

	public BigInteger getFinish() {
		return finish;
	}

}