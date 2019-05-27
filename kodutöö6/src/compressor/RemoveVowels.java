package compressor;

/**
 * Created by Jaanus on 28.10.16.
 */
public class RemoveVowels implements Compressor {
    @Override
    public String compress(String stringToCompress) {
        return removeExtraSpaces(removeVowels(stringToCompress));
    }

    private String removeExtraSpaces(String stringToRemoveSpacesFrom) {
        return stringToRemoveSpacesFrom.replaceAll("( )+", " ");
    }

    private String removeVowels(String stringToRemoveVowelsFrom) {
        return stringToRemoveVowelsFrom.replaceAll("[aeiouöõüäAEIOUÖÕÄÜ]+", "");
    }
}
