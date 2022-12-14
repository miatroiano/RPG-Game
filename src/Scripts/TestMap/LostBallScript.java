package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

// trigger script at beginning of game to set that heavy emotional plot
public class LostBallScript extends Script {
    @Override
    protected void setup() {
	lockPlayer();
	showTextbox();
	String[] selections = { "Here", "There", "Anywhere" };
	String[] answers = { "You selected Here.", "You selected There.", "You selected Anywere." };
	addTextToTextboxQueue("Where did my ball go!?", selections, answers);
	addTextToTextboxQueue("I left it right here before I took my 22 hour cat nap.");
	addTextToTextboxQueue("Maybe Walrus has seen it.");
    }

    @Override
    protected void cleanup() {
	setFlag("hasLostBall");
	hideTextbox();
	unlockPlayer();
    }

    @Override
    public ScriptState execute() {
	if (!isFlagSet("hasLostBall")) {
	    start();
	    if (!isTextboxQueueEmpty()) {
		return ScriptState.RUNNING;
	    }
	    end();
	}
	return ScriptState.COMPLETED;
    }
}
