package searchengine.controllers;

public class Storage_arсhive {

    // База сохранения локальная из примеров обучения

    /*private static int currentId = 1;
    private static int currentPageId = 1;

    private static int currentLemmaId = 1;

    private static int currentIndexId = 1;

//    IndexSql
    private static final ConcurrentHashMap<Integer, SiteSql> sites = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, PageSql> pages = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<Integer, Lemma> lemmas = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<Integer, IndexSql> indexes = new ConcurrentHashMap<>();

    public static List<SiteSql> getAllSites() {
        ArrayList<SiteSql> sitesList = new ArrayList<>();
        sitesList.addAll(sites.values());
        return sitesList;
    }

    public static List<PageSql> getAllPages() {
        ArrayList<PageSql> pagesList = new ArrayList<>();
        pagesList.addAll(pages.values());
        return pagesList;
    }

    public static List<Lemma> getAllLemmas() {
        ArrayList<Lemma> lemmasList = new ArrayList<>();
        lemmasList.addAll(lemmas.values());
        return lemmasList;
    }

    public static List<IndexSql> getAllIndexes() {
        ArrayList<IndexSql> IndexesList = new ArrayList<>();
        IndexesList.addAll(indexes.values());
        return IndexesList;
    }

    public static int addSite(SiteSql siteSql) {
        int id = currentId++;
        siteSql.setId(id);
        sites.put(id, siteSql);
        return id;
    }

    public static int addPage(PageSql pageSql) {
        int id = currentPageId++;
        pageSql.setId(id);
        pages.put(id, pageSql);
        return id;
    }

    public static int addLemma(Lemma lemma) {
        int id = currentLemmaId++;
        lemma.setId(id);
        lemmas.put(id, lemma);
        return id;
    }

    public static int addIndex(IndexSql indexSql) {
        int id = currentIndexId++;
        indexSql.setId(id);
        indexes.put(id, indexSql);
        return id;
    }

    public static int setSite(SiteSql siteSql) {
        int idSite = siteSql.getId();
        sites.put(idSite, siteSql);
        return idSite;
    }

    public static int setPage(PageSql pageSql) {
        int idPage = pageSql.getId();
        pages.put(idPage, pageSql);
        return idPage;
    }

    public static int setLemma(Lemma lemma) {
        int idLemma = lemma.getId();
        lemmas.put(idLemma, lemma);
        return idLemma;
    }

    public static int setIndex(IndexSql indexSql) {
        int idIndex = indexSql.getId();
        indexes.put(idIndex, indexSql);
        return idIndex;
    }

    public static SiteSql getSite(int siteId) {
        if (sites.containsKey(siteId)) {
            return sites.get(siteId);
        }
        return null;
    }

    public static PageSql getPage(int pageId) {
        if (pages.containsKey(pageId)) {
            return pages.get(pageId);
        }
        return null;
    }

    public static Lemma getLemma(int lemmaId) {
        if (lemmas.containsKey(lemmaId)) {
            return lemmas.get(lemmaId);
        }
        return null;
    }

    public static IndexSql getIndex(int indexId) {
        if (indexes.containsKey(indexId)) {
            return indexes.get(indexId);
        }
        return null;
    }

    public static int dellSite(int siteId) {
        if (sites.containsKey(siteId)) {
            sites.remove(siteId);
            return siteId;
        }
        return 0;
    }

    public static int dellPage(int pageId) {
        if (pages.containsKey(pageId)) {
            pages.remove(pageId);
            return pageId;
        }
        return 0;
    }

    public static int dellLemma(int lemmaId) {
        if (lemmas.containsKey(lemmaId)) {
            lemmas.remove(lemmaId);
            return lemmaId;
        }
        return 0;
    }

    public static int dellIndex(int indexId) {
        if (indexes.containsKey(indexId)) {
            indexes.remove(indexId);
            return indexId;
        }
        return 0;
    }

    public static int dellAllSites() {
        sites.clear();
        currentId = 1;
        return 0;
    }

    public static int dellAllPages() {
        pages.clear();
        currentPageId = 1;
        return 0;
    }

    public static int dellAllLemmas() {
        lemmas.clear();
        currentLemmaId = 1;
        return 0;
    }

    public static int dellAllIndexes() {
        indexes.clear();
        currentIndexId = 1;
        return 0;
    }*/
}
