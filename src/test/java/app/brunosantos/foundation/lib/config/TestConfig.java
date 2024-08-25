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
 * Configuration class for setting up beans used in testing.
 * This configuration provides the necessary components for hash strategies
 * (MD5, SHA-256, SHA-512) and a hash verifier, enabling consistent and isolated
 * testing of cryptographic operations. The {@link MessageResolver} bean is also
 * configured to resolve error messages for input validation.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.brunosantos.foundation.lib.commons.identifier.hash.HashVerifier;
import app.brunosantos.foundation.lib.commons.identifier.hash.strategy.Md5HashStrategy;
import app.brunosantos.foundation.lib.commons.identifier.hash.strategy.Sha256HashStrategy;
import app.brunosantos.foundation.lib.commons.identifier.hash.strategy.Sha512HashStrategy;
import app.brunosantos.foundation.lib.commons.messages.MessageResolver;
import app.brunosantos.foundation.lib.commons.messages.ResourceBundleMessageResolver;

import java.util.ResourceBundle;

@Configuration
public class TestConfig {
    @Bean
    public MessageResolver messageResolver() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("test-messages");
        return new ResourceBundleMessageResolver(resourceBundle);
    }

    @Bean
    public Md5HashStrategy md5HashStrategy(MessageResolver messageResolver) {
        return new Md5HashStrategy(messageResolver);
    }

    @Bean
    public Sha256HashStrategy sha256HashStrategy(MessageResolver messageResolver) {
        return new Sha256HashStrategy(messageResolver);
    }

    @Bean
    public Sha512HashStrategy sha512HashStrategy(MessageResolver messageResolver) {
        return new Sha512HashStrategy(messageResolver);
    }

    @Bean
    public HashVerifier hashVerifier(MessageResolver messageResolver) {
        return new HashVerifier(messageResolver);
    }
}
