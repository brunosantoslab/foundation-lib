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
 * Verifier for checking if an input string, when hashed, matches a provided hash.
 * This class is designed to work with any implementation of the HashStrategy interface,
 * enabling reusable and consistent verification logic across different hash algorithms.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib.commons.identifier.hash;

import app.brunosantos.foundation.lib.commons.identifier.hash.strategy.HashStrategy;
import app.brunosantos.foundation.lib.commons.messages.MessageResolver;
import app.brunosantos.foundation.lib.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HashVerifier {

    private final MessageResolver messageResolver;

    @Autowired
    public HashVerifier(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    /**
     * Verifies if the input, when hashed using the provided HashStrategy, matches the provided hash.
     *
     * @param input the input to hash and compare
     * @param hash the expected hash
     * @param hashStrategy the strategy to use for hashing the input
     * @return true if the hashed input matches the provided hash, false otherwise
     * @throws InvalidInputException if the input or hash is null
     */
    public boolean verify(String input, String hash, HashStrategy hashStrategy) {
        if (input == null || hash == null) {
            throw new InvalidInputException("input.invalid", input, messageResolver);
        }
        String generatedHash = hashStrategy.generateHash(input);
        return generatedHash.equals(hash);
    }
}
