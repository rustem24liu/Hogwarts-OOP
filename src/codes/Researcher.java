package codes;

import java.util.Comparator;

public interface Researcher {
    void printPapers(Comparator<ResearchPaper> r );
    int hIndex();
}