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
 * Implementation of {@link MessageResolver} using a resource bundle.
 * This class is responsible for resolving message keys to strings using a specified
 * resource bundle, allowing for localization and consistent messaging across the application.
 * It is particularly useful in scenarios where internationalization (i18n) is required.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib.commons.messages;

import java.util.ResourceBundle;

public class ResourceBundleMessageResolver implements MessageResolver {

    private final ResourceBundle resourceBundle;

    public ResourceBundleMessageResolver(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String resolve(String messageKey) {
        return resourceBundle.getString(messageKey);
    }
}
