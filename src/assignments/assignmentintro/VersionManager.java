package assignments.assignmentintro;

import java.util.*;


public class VersionManager {
    private Version currentVersion;
    private ArrayList<Version> previousVersions = new ArrayList<>();

    public VersionManager() {
        currentVersion = new Version();
        previousVersions.add(currentVersion);
    }

    public VersionManager(String patch) {
        currentVersion = new Version(patch);
        previousVersions.add(currentVersion);
    }

    public VersionManager major() {
        previousVersions.add(new Version(currentVersion.toString()));
        currentVersion.setMajor(currentVersion.getMajor() + 1);
        currentVersion.setMinor(0);
        currentVersion.setPatch(0);
        return this;
    }

    public VersionManager minor() {
        previousVersions.add(new Version(currentVersion.toString()));
        currentVersion.setMinor(currentVersion.getMinor() + 1);
        currentVersion.setPatch(0);
        return this;
    }

    public VersionManager patch() {
        previousVersions.add(new Version(currentVersion.toString()));
        currentVersion.setPatch(currentVersion.getPatch() + 1);
        return this;
    }

    public String release() {
        return currentVersion.toString();
    }

    public VersionManager rollback() {

        if(previousVersions.size() != 1) {
            currentVersion = previousVersions.get(previousVersions.size() - 1);
            previousVersions.remove(previousVersions.size() - 1);
        }
        else {
            throw new NoSuchElementException("Cannot rollback!");
        }



        return this;
    }

}