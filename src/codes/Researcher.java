package codes;

import java.io.IOException;
import java.util.Comparator;

public interface Researcher {
    default void writeResearch() throws IOException {
    }

    default void printPapers(Comparator<ResearchPaper> r) {
    }

    default int hIndex() {
        return 0;
    }
}