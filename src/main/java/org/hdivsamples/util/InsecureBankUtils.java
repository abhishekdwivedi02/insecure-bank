package org.hdivsamples.util;

import com.google.common.base.Preconditions;

import java.io.File;

public abstract class InsecureBankUtils {
	private static int refCount = 0;
	private int value;

	public static double round(double value, final int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
	public static String getFileExtension(String fullName) {
		Preconditions.checkNotNull(fullName);
		String fileName = (new File(fullName)).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return dotIndex == -1 ? "" : fileName.substring(dotIndex + 1);
	}

	public static String getNameWithoutExtension(String file) {
		Preconditions.checkNotNull(file);
		String fileName = (new File(file)).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
	}

 public synchronized void doStuff() {
        refCount++; //A NON_STATIC_GUARDING_STATIC defect here.
    }
	
public synchronized int get() { return value; }

    public synchronized void put(int v) { value = v; }

    public void increment() {
        int tmp = get();
        put(tmp + 1); // Defect: desired value for tmp might have changed
    }
    
    int f(InputStream is) throws IOException
    {
      byte buffer[] = new byte[10];
      // Number of copied bytes is ignored
      if (is.read(buffer, 0 , 10) < 0) {
        return -1;
      }
      // 'buffer' may be accessed out of range.
      return buffer[9];
    }

	
}
