package compressor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

/**
 * Created by Jaanus on 28.10.16.
 */
public class RemoveVowelsTest {
    private Compressor compressor;

    @Before
    public void setUp() {
        compressor = new RemoveVowels();
    }

    @Test
    public void basicCompressString() {
        assertEquals("ln", compressor.compress("olen"));
    }

    @Test
    public void compressString() {
        assertEquals("vstsm lvndlg, sndd n kllsd j skvd lld", compressor.compress("Avastasime uue elevandiliigi, isendid on kollased ja oskavad laulda"));
    }

    @Test
    public void compressStringSeveralWordsWithOnlyVowelsInRow() {
        assertEquals("m nd", compressor.compress("ma ai ou ui nüüd"));
    }
}
