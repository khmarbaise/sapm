package com.soebes.subversion.sapm;

public class Path {

    private String path;

    public Path(String path) {
        super();
        setPath(path);
    }

    public Path() {
        setPath(null);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean contains(String path) {
        boolean result = false;
        FileName fn = new FileName(path);
        if (fn.getPath().startsWith(getPath())) {
            result = true;
        }
        return result;
    }

}
