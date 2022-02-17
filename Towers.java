import java.util.Stack;

public class Towers {

  private static final int NUM_PEGS = 3;

  private Stack<Integer>[] pegs;

  public Towers(int numDisks) {
    this.pegs = (Stack<Integer>[]) new Stack[NUM_PEGS];

    for (int i = 0; i < this.pegs.length; i++) {
      this.pegs[i] = new Stack<Integer>();
    }

    for (int i = 0; i < numDisks; i++) {
      this.pegs[0].push(numDisks - i);
    }
  }

  public void solve() {
    Stack<Move> stack = new Stack<Move>();
    Stack<Move> moves = new Stack<Move>();

    stack.push(new Move(this.pegs[0].size(), 0, 2));

    while (!stack.empty()) {
      Move currentMove = stack.pop();

      if (currentMove.getNumDisks() == 1) {
        Move nextMoveToMake = new Move(
          currentMove.getNumDisks(),
          currentMove.getFromPeg(),
          currentMove.getToPeg()
        );

        moves.push(nextMoveToMake);
      } else {
        int temporaryPeg =
          3 - currentMove.getToPeg() - currentMove.getFromPeg();

        Move topOfStackToTemporaryPeg = new Move(
          currentMove.getNumDisks() - 1,
          currentMove.getFromPeg(),
          temporaryPeg
        );

        Move singleDiskToDestinationPeg = new Move(
          1,
          currentMove.getFromPeg(),
          currentMove.getToPeg()
        );

        Move topOfStackToDestinationPeg = new Move(
          currentMove.getNumDisks() - 1,
          temporaryPeg,
          currentMove.getToPeg()
        );

        stack.push(topOfStackToDestinationPeg);
        stack.push(singleDiskToDestinationPeg);
        stack.push(topOfStackToTemporaryPeg);
      }
    }

    displayMoves(moves);
  }

  public void displayMoves(Stack<Move> moves) {
    String s = "";
    
    while (!moves.isEmpty()) {
      s = moves.pop() + "\n" + s;
    }

    System.out.println(s);
  }

  public String toString() {
    String result = "";

    for (int i = 0; i < pegs.length; i++) {
      Stack<Integer> peg = pegs[i];
      Stack<Integer> stack = new Stack<Integer>();

      result += (char) ('a' + i);

      while (!peg.empty()) {
        stack.push(peg.pop());
      }

      while (!stack.isEmpty()) {
        int disk = stack.pop();
        result += " " + disk;
        peg.push(disk);
      }

      result += "\n";
    }

    return result;
  }
}
