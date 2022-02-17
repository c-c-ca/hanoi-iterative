public class Move {

  private int numDisks;
  private int fromPeg;
  private int toPeg;

  public Move(int numDisks, int fromPeg, int toPeg) {
    this.numDisks = numDisks;
    this.fromPeg = fromPeg;
    this.toPeg = toPeg;
  }

  public int getNumDisks() {
    return this.numDisks;
  }

  public int getFromPeg() {
    return this.fromPeg;
  }

  public int getToPeg() {
    return this.toPeg;
  }

  public String toString() {
    return "Move disk from " + this.fromPeg + " to " + this.toPeg;
  }
}
