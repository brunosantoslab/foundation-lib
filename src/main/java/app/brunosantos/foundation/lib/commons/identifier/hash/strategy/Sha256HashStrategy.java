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
 * Implementation of the HashStrategy interface using the SHA-256 algorithm.
 * This class provides a secure mechanism for generating hashes with SHA-256.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib.commons.identifier.hash.strategy;

import app.brunosantos.foundation.lib.commons.messages.MessageResolver;
import app.brunosantos.foundation.lib.exception.InvalidInputException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sha256HashStrategy implements HashStrategy {

    private final MessageResolver messageResolver;

    @Autowired
    public Sha256HashStrategy(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    @Override
    public String generateHash(String input) {
        if (input == null) {
            throw new InvalidInputException("input.notNull", input, messageResolver);
        } else if (input.isEmpty()) {
            throw new InvalidInputException("input.notEmpty", input, messageResolver);
        }
        return DigestUtils.sha256Hex(input);
    }
}