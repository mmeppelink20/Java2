package assignments.assignmentintro;

public class Version {
    private int major;
    private int minor;
    private int patch;


    public Version() {
        major = 0;
        minor = 0;
        patch = 1;
    }


    public Version(String version) {
        try{
            String[] splitVersion = version.split("\\.");

            if (splitVersion.length == 1 && splitVersion[0].equals("")) {
                patch = 1;
                return;
            }

            switch (splitVersion.length) {
                case 0:
                    patch = 1;
                    break;
                case 1:
                    major = Integer.parseInt(splitVersion[0]);
                    break;
                case 2:
                    major = Integer.parseInt(splitVersion[0]);
                    minor = Integer.parseInt(splitVersion[1]);
                    break;
                default:
                    major = Integer.parseInt(splitVersion[0]);
                    minor = Integer.parseInt(splitVersion[1]);
                    patch = Integer.parseInt(splitVersion[2]);
                    break;
            }
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Error occured while parsing version!");
        }

    }

    public Version(int major, int minor, int patch) {
        validateVersionNumber(major);
        this.major = major;
        validateVersionNumber(minor);
        this.minor = minor;
        validateVersionNumber(patch);
        this.patch = patch;
    }

    private void validateVersionNumber(int a) {
        if(a < 0) {
            throw new IllegalArgumentException("Version number must be a positive number");
        }
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

    public void major() {
        major++;
        minor = 0;
        patch = 0;
    }

    public void minor() {
        minor++;
        patch = 0;
    }

    public void patch() {
        patch++;
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + patch;
    }

    public String release() {
        return toString();
    }
}
