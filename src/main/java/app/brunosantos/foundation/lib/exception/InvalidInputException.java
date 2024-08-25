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
 * Exception thrown when the input data for generating a hash is invalid.
 * This could be due to null or empty input, or other issues that prevent
 * the hash from being generated correctly.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib.exception;

import app.brunosantos.foundation.lib.commons.messages.MessageResolver;
import java.text.MessageFormat;
public class InvalidInputException extends RuntimeException {

    private final String messageKey;
    private final transient MessageResolver messageResolver;

    /**
     * Constructor for InvalidInputException.
     *
     * @param messageKey      the key used to resolve the error message
     * @param messageResolver the resolver used to resolve the message
     */
    public InvalidInputException(String messageKey, MessageResolver messageResolver) {
        super(messageResolver.resolve(messageKey));
        this.messageKey = messageKey;
        this.messageResolver = messageResolver;
    }

    /**
     * Constructor for InvalidInputException with a formatted message.
     *
     * @param messageKey      the key used to resolve the error message
     * @param input           the invalid input that caused the exception
     * @param messageResolver the resolver used to resolve the message
     */
    public InvalidInputException(String messageKey, String input, MessageResolver messageResolver) {
        super(MessageFormat.format(messageResolver.resolve(messageKey), input));
        this.messageKey = messageKey;
        this.messageResolver = messageResolver;
    }

    /**
     * Returns the message key associated with this exception.
     * 
     * @return the message key
     */
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * Provides a mechanism to resolve the message using the MessageResolver.
     * This will return null if the exception is deserialized without a valid messageResolver.
     * 
     * @return the resolved message based on the message key, or null if the resolver is unavailable
     */
    public String getResolvedMessage() {
        if (messageResolver != null) {
            return messageResolver.resolve(messageKey);
        }
        return null;
    }
}
