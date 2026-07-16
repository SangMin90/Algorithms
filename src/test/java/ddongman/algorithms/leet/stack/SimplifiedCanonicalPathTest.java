package ddongman.algorithms.leet.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimplifiedCanonicalPathTest {

    private SimplifiedCanonicalPath sut;

    @BeforeEach
    void setUp() {
        sut = new SimplifiedCanonicalPath();
    }

    @Test
    void case1() {
        String path = "/home/";

//        String result = sut.simplifyPath(path);
        String result = sut.simplifyPath2(path);

        assertThat(result).isEqualTo("/home");
    }

    @Test
    void case2() {
        String path = "/home//foo/";

//        String result = sut.simplifyPath(path);
        String result = sut.simplifyPath2(path);

        assertThat(result).isEqualTo("/home/foo");
    }

    @Test
    void case3() {
        String path = "/home/user/Documents/../Pictures";

//        String result = sut.simplifyPath(path);
        String result = sut.simplifyPath2(path);

        assertThat(result).isEqualTo("/home/user/Pictures");
    }

    @Test
    void case4() {
        String path = "/../";

//        String result = sut.simplifyPath(path);
        String result = sut.simplifyPath2(path);

        assertThat(result).isEqualTo("/");
    }

    @Test
    void case5() {
        String path = "/.../a/../b/c/../d/./";

//        String result = sut.simplifyPath(path);
        String result = sut.simplifyPath2(path);

        assertThat(result).isEqualTo("/.../b/d");
    }

    @Test
    void case6() {
        String path = "/.../a/../b/c/../d";

//        String result = sut.simplifyPath(path);
        String result = sut.simplifyPath2(path);

        assertThat(result).isEqualTo("/.../b/d");
    }
}