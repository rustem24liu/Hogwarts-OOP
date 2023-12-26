package codes;

import java.util.Comparator;

public class CitationComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        // Compare in descending order based on the number of citations
        return Integer.compare(paper2.getCitation(), paper1.getCitation());
    }
}
