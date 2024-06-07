import inline as inline
import matplotlib
import numpy as np
def do_tosses(ntosses):
    # I've left adding comments as an exercise...
    outcomes = np.random.rand(ntosses) > 0.5
    sequence_length = 1
    sequence_lengths = []
    last_outcome = outcomes[0]
    for outcome in outcomes[1:]:
        if outcome != last_outcome:
            sequence_lengths.append(sequence_length)
            sequence_length = 1
        else:
            sequence_length += 1
        last_outcome = outcome
    sequence_lengths.append(sequence_length)
    return sequence_lengths

sequence_lengths = do_tosses(5)
print(sequence_lengths)

