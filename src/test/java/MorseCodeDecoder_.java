import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MorseCodeDecoder_ {
    @Test
    public void should_return_empty_given_empty(){
        assertThat(MorseCodeDecoder.get("")).isEqualTo("");
        assertThat(MorseCodeDecoder.get("    ")).isEqualTo("");
        assertThat(MorseCodeDecoder.get("        ")).isEqualTo("");
    }
    @Test
    public void should_return_E_given_E(){
        assertThat(MorseCodeDecoder.get(".")).isEqualTo("E");
    }

    @Test
    public void should_return_HEY_JUDE_given_HEY_JUDE(){
        assertThat(MorseCodeDecoder.get(".... . -.--     .--- ..- -.. .")).isEqualTo("HEY JUDE");
    }

}
