package challenge;
class Place {
    private String name;
    private int distanceSydney;

    public Place(String name, int distanceSydney) {
        this.name = name;
        this.distanceSydney = distanceSydney;
    }

    public String getName() {
        return name;
    }

    public int getDistanceSydney() {
        return distanceSydney;
    }

    @Override
    public String toString() {
        return "[ " +name + ":" + distanceSydney + "km (from Sydney)]";
    }
}
