# Chicken Challenge
Small game with focus on using Design Patterns.
## About
Your main goal in this game is to cross the road as a small chicken. Watch out, as some vehicle behavior can be unpredictable. After reaching right side, the next map is generated randomly, hp points restored and level increased. 

For controling your character use arrows (<- and ->) or change controls in Settings Menu. Use arrows and enter to navigate through menus and q to quit to the main menu/quit the game. 

The purpose of creating this game was purely educational. I tried to use a lot of design patterns and follow object-oriented design principles, even if some of them weren't necessary in this small project.

Pixel art by me.

## Design Patterns
  1. State - altering between game screens, such as Main Menu, Settings etc.
  2. Singleton - ensuring only one instance of Player class and providing global access to it.
  3. Template method - skeleton of algorithm in `render()` method - used in abstract class GameScreenState, subclasses override some steps.
  4. Composite - composing drawable objects (graphics) into tree structure.
  5. Prototype - used in spawning Vehicles on Road, radomly producing clones of generic prototypes in prototype registry (VehicleRegitry class, Vehicle has `clone()` method).
  6. Command - encapsulating commands, such as moving Player, allowing to easily change controls in settings.
  7. Decorator - attaching new behavior to Command in MenuButton class.
  8. Adapter - adapting Command to Drawable interface.
  9. Strategy - family of interchangeable driving algorithms for Vehicle objects.
  10. Observer - Road (Observable) is notyfing Vehicles (Observer) about certain evens, allowing Vehicles to change their behavior. 
  11. Flyweight - all instances of MovingSnowflake class share common parts.
  12. (Null Object - NullCommand class used instead of checking if object is null)
  
  

