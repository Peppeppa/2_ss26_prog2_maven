package de.thws.klausurvorbereitung.websiteThreads;

import java.util.function.Consumer;

public class WebsiteChangeWatcher {

    private String target;
    private String path;

    private Consumer<String> consumer;
    private Thread thread;
    private volatile boolean cancelled = false;

    public WebsiteChangeWatcher(String target, String path, Consumer<String> consumer) {
        this.target = target;
        this.path = path;
        this.consumer = consumer;
    }

    public void hasChanged() {
        thread = new Thread(() -> {
            try {
                String content = retrieveWebsiteContent();

                while (!cancelled) {
                    Thread.sleep(30000);

                    String newContent = retrieveWebsiteContent();

                    if (!content.equals(newContent)) {
                        consumer.accept(newContent);
                        content = newContent;
                    }
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public void cancel() {
        cancelled = true;

        if (thread != null) {
            thread.interrupt();
        }
    }

    /**
     * Reads the content of a website and returns its content as html.
     * @return The content of a website as String.
     */
    private String retrieveWebsiteContent() {
        // Implementierung ist laut Aufgabenstellung gegeben
        return "";
    }

    public static void main(String[] args) {
        Consumer<String> consumer = newContent -> {
            System.out.println("Änderung festgestellt:");
            System.out.println(newContent);
        };

        WebsiteChangeWatcher watcher =
                new WebsiteChangeWatcher("https://www.zeit.de", "campus", consumer);

        watcher.hasChanged();

        try {
            Thread.sleep(2 * 60 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        watcher.cancel();
        System.out.println("Überprüfung beendet.");
    }
}