/*
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
 * Main application class for the Bruno Santos Foundation Library, responsible for initializing the Spring context.
 * This class serves as the entry point for the application.
 *
 * @author Bruno da Silva Santos <contact@brunosantos.app>
 * @since 0.0.1-alpha
 * @see <a href="https://github.com/brunosantoslab/foundation-lib/wiki">Library Documentation</a>
 */
package app.brunosantos.foundation.lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Bruno Santos Foundation Library.
 */
@SpringBootApplication
public class BrunoSantosFoundationLibraryApplication {

  /**
   * Runs the Spring application with the provided command-line arguments.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(BrunoSantosFoundationLibraryApplication.class, args);
  }

}