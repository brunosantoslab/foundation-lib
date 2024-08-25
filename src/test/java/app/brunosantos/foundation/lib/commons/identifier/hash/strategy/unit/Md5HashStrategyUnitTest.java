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
 * Unit test for Md5HashStrategy to ensure accurate functionality and reliability in all scenarios.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib.commons.identifier.hash.strategy.unit;

import app.brunosantos.foundation.lib.commons.identifier.hash.HashVerifier;
import app.brunosantos.foundation.lib.commons.identifier.hash.strategy.Md5HashStrategy;
import app.brunosantos.foundation.lib.config.TestConfig;
import app.brunosantos.foundation.lib.exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static app.brunosantos.foundation.lib.util.TestDataProvider.VALID_INPUT;
import static app.brunosantos.foundation.lib.util.TestDataProvider.ANOTHER_INPUT;
import static app.brunosantos.foundation.lib.util.TestDataProvider.EMPTY_INPUT;
import static app.brunosantos.foundation.lib.util.TestDataProvider.NULL_INPUT;
/**
 * Unit tests for {@link Md5HashStrategy}.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
class Md5HashStrategyUnitTest {

    @Autowired
    private Md5HashStrategy md5HashStrategy;

    @Autowired
    private HashVerifier hashVerifier;

    @ParameterizedTest
    @MethodSource("app.brunosantos.foundation.lib.util.TestDataProvider#provideValidHashInputsForMd5")
    void testGenerateHashWithVariousValidInputs(String input, String expectedHash) {
        String actualHash = md5HashStrategy.generateHash(input);
        assertEquals(expectedHash, actualHash, "The generated hash should match the expected hash.");
    }

    @Test
    void testGenerateHashWithNullInput() {
        Executable executable = () -> md5HashStrategy.generateHash(NULL_INPUT);
        InvalidInputException exception = assertThrows(InvalidInputException.class, executable);

        assertEquals("Input cannot be null", exception.getMessage(), "The exception message should indicate the input cannot be null.");
    }

    @Test
    void testGenerateHashWithEmptyInput() {
        Executable executable = () -> md5HashStrategy.generateHash(EMPTY_INPUT);
        InvalidInputException exception = assertThrows(InvalidInputException.class, executable);

        assertEquals("Input cannot be empty", exception.getMessage(), "The exception message should indicate the input cannot be empty.");
    }

    @Test
    void testVerifyWithMatchingInputAndHash() {
        String hash = md5HashStrategy.generateHash(VALID_INPUT);
        boolean result = hashVerifier.verify(VALID_INPUT, hash, md5HashStrategy);
        assertTrue(result, "The verifier should return true for matching input and hash.");
    }

    @Test
    void testVerifyWithNonMatchingInputAndHash() {
        String hash = md5HashStrategy.generateHash(ANOTHER_INPUT);
        boolean result = hashVerifier.verify(VALID_INPUT, hash, md5HashStrategy);
        assertFalse(result, "The verifier should return false for non-matching input and hash.");
    }

}
