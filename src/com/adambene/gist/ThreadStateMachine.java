package com.adambene.gist;

import static com.adambene.gist.ThreadStateMachine.Transition.CREATE;
import static com.adambene.gist.ThreadStateMachine.Transition.FINISH;
import static com.adambene.gist.ThreadStateMachine.Transition.RESUME;
import static com.adambene.gist.ThreadStateMachine.Transition.WAIT;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadStateMachine
{
    private static Logger LOGGER = Logger.getLogger(ThreadStateMachine.class.getName());

    public static enum State
    {
        NEW
        {
            @Override public State next(Transition transition)
            {
                return (transition == CREATE) ? RUNNING : ILLEGAL;
            }
        },
        RUNNING
        {
            @Override public State next(Transition transition)
            {
                if (transition == WAIT)
                {
                    return BLOCKED;
                }
                else if (transition == FINISH)
                {
                    return DEAD;
                }
                else
                {
                    return ILLEGAL;
                }
            }
        },
        BLOCKED
        {
            @Override public State next(Transition transition)
            {
                return (transition == RESUME) ? RUNNING : ILLEGAL;
            }
        },
        DEAD
        {
            @Override public State next(Transition transition)
            {
                return ILLEGAL;
            }
        },
        ILLEGAL
        {
            @Override public State next(Transition transition)
            {
                return ILLEGAL;
            }
        };

        public State next(Transition transition)
        {
            return null;
        }
    }

    public static enum Transition
    {
        CREATE,
        WAIT,
        RESUME,
        FINISH
    }

    public static void main(String[] args)
    {
        State finish = run(State.NEW, CREATE, WAIT, RESUME, WAIT, RESUME, FINISH);
    }

    public static State run(State start, Transition... transitions)
    {
        State state = start;

        LOGGER.log(Level.INFO, "start state: {0}", start);
        for (Transition transition : transitions)
        {
            state = state.next(transition);
            LOGGER.log(Level.INFO, "current state: {0}", state);
        }

        LOGGER.info("finished");

        return state;
    }
}
