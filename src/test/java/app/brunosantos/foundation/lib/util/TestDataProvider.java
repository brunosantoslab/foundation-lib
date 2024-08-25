/**
 * Copyright 2024 Bruno da Silva Santos
 *
 * Licensed under the Creative Commons Attribution-NonCommercial 4.0 International License
 * (the "License"). You may not use this file except in compliance with the License.
 * A copy of the License is available at:
 *
 * https://creativecommons.org/licenses/by-nc/4.0/
 *
 * This license applies to all content, media, and software included in this project.
 * Attribution is required, and commercial use is prohibited.
 * For inquiries or permissions beyond the scope of this license, please contact:
 * <a href="mailto:contact@brunosantos.app">contact@brunosantos.app</a>.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is provided "AS IS", without warranties or conditions of any kind.
 * See the License for the specific language governing permissions and limitations under the License.
 *
 * Provides common test data for unit tests.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {

    public static final String VALID_INPUT = "test";
    public static final String ANOTHER_INPUT = "anotherTest";
    public static final String NUMERIC_INPUT = "1234567890";
    public static final String SPECIAL_CHARACTERS_INPUT = "!@#$%^&*()";
    public static final String EMPTY_INPUT = "";
    public static final String NULL_INPUT = null;
    public static final String WHITESPACE_INPUT = "   ";
    public static final String LONG_INPUT = "a".repeat(1000);
    public static final String UNICODE_INPUT = "测试输入";

    private TestDataProvider() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Stream<Arguments> provideValidHashInputsForMd5() {
        return Stream.of(
                Arguments.of(VALID_INPUT, DigestUtils.md5Hex(VALID_INPUT)),
                Arguments.of(WHITESPACE_INPUT, DigestUtils.md5Hex(WHITESPACE_INPUT)),
                Arguments.of(SPECIAL_CHARACTERS_INPUT, DigestUtils.md5Hex(SPECIAL_CHARACTERS_INPUT)),
                Arguments.of(LONG_INPUT, DigestUtils.md5Hex(LONG_INPUT)),
                Arguments.of(UNICODE_INPUT, DigestUtils.md5Hex(UNICODE_INPUT))
        );
    }

    public static Stream<Arguments> provideValidHashInputsForSha256() {
        return Stream.of(
                Arguments.of(VALID_INPUT, DigestUtils.sha256Hex(VALID_INPUT)),
                Arguments.of(ANOTHER_INPUT, DigestUtils.sha256Hex(ANOTHER_INPUT)),
                Arguments.of(NUMERIC_INPUT, DigestUtils.sha256Hex(NUMERIC_INPUT)),
                Arguments.of(SPECIAL_CHARACTERS_INPUT, DigestUtils.sha256Hex(SPECIAL_CHARACTERS_INPUT))
        );
    }

    public static Stream<Arguments> provideValidHashInputsForSha512() {
        return Stream.of(
                Arguments.of(VALID_INPUT, DigestUtils.sha512Hex(VALID_INPUT)),
                Arguments.of(ANOTHER_INPUT, DigestUtils.sha512Hex(ANOTHER_INPUT))
        );
    }

}
