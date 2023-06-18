# UML Diagram

For subpackage `graphicState`.

____

````mermaid
classDiagram
direction BT
class InsideState {
  - InsideState instance
  + getInstance(Scene) InsideState
  + drawInside() State
  + drawOutside() State
}
class OutsideState {
  - OutsideState instance
  + drawOutside() State
  + drawInside() State
  + getInstance(Scene) OutsideState
}

class State {
    <<abstract>>
  # Scene context
  # OutsideState outside
  # InsideState inside
  + drawOutside() State
  + drawInside() State
}

InsideState  --|>  State 
OutsideState  --|>  State 

````