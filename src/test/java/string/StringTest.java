package string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringTest {

    @Test
    void split_테스트() {
        String str = "1,2,3";
        String[] splitStr = str.split(",");

        assertThat(splitStr).contains("1", "2");
        assertThat(splitStr).containsExactly("1", "2", "3");
    }

    @Test
    void substring_테스트() {
        String str = "(1,2,3,5)";
        String substring = str.substring(1, str.length() - 1);      //  substring으로 괄호를 자를때는 입력이 바뀔걸 대비해서 str.length() - 1 이렇게 to부분을 문자열 길이에서 1을 뺀다

        assertThat(substring).isEqualTo("1,2,3,5");
    }

    @Test
    @DisplayName("예외 처리 테스트")
    void 예외발생() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(5)).isInstanceOf(IndexOutOfBoundsException.class);
    }



}
