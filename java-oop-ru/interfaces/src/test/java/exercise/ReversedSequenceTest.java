package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReversedSequenceTest {
    public CharSequence text = new ReversedSequence("abcdef");

//    @BeforeEach
//    void beforeEach() {
//        CharSequence text = new ReversedSequence("abcdef");
//    }
//



    @Test
    void length() {

        int actual = text.length();
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void charAt() {
        char actual = text.charAt(1);
        char expected = 'e';
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subSequence() {
        String actual = text.subSequence(1, 4).toString();
        String expected = "edc";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void isEmpty() {
        boolean actual = text.isEmpty();
        boolean expected = false;
        assertThat(actual).isEqualTo(expected);
    }

}