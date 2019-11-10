# PairProgramming Activity

## LinkedList Dictionary
![Dictionary](https://www.dailydot.com/wp-content/uploads/d89/cd/ddc38d1af1e11ba9835fedd40edf574d.jpg)

### _Participants_

- Martina de Armas
- Vicente Hoyos

### TASKS

- Add code that performs a verification test when the value “-1” is passed to the program as an argument
(5 points)
_Done_

- Why don’t we choose the word “test” as an argument to activate the test?
_Passing an argument as "test" would make a search through the sorted dictionary instead of making a comparison between files._

- Check with several words that the position matches (5 points)
- Performs a full test of the 10,000 words (10 points)
- Performance test (25 points) _The performance test is under the branch "Testing"_
- Place several timers to control what time it takes to do certain tasks. Do printouts to see that info on the
console (5 points)
- Since some tasks take a variable amount of time, calculate the average, maximum and minimum of
certain tasks to have a better understanding of the limitations of our algorithms (10 points)
- Find bottlenecks and fix them (10 points)
- Check against different inputs (10 points)
- Inputs not expected
- Numbers beyond the limits
- etc

### CODE CORRECTIONS

- *bugs*

else{
                                current = current.next;    
                                
                                if (current.next == null){
                                    Node temp = new Node(line);
                                    if (current.data.compareToIgnoreCase(line) > 0){
                                        temp.next = current;
                                        dictionary.get(index).next = temp;
                                        dictionary.add(index + 1, temp);
                                    }
                                    else{
                                        dictionary.getLast().next = temp;
                                        dictionary.addLast(temp);                         
                                    }
                                    break;
                                }
                                index ++;
                            }
