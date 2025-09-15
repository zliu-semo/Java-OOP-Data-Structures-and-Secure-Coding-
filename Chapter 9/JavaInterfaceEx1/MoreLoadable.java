package processing;

/**
 * Example of an interface extension
 */
public interface MoreLoadable extends Loadable {
    /* public */ void downloadJSON(String json);
}