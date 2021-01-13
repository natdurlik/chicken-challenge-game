# Chicken Challenge
Small game with focus on using Design Patterns.
## About
Your main goal in this game is to cross the road as a small chicken. Watch out, as some vehicle behavior can be unpredictable. After reaching right side, the next map is generated randomly, hp points restored and level increased. 

For controling your character use arrows (<- and ->) or change controls in Settings Menu. Use arrows and enter to navigate through menus and q to quit to the main menu/quit the game. 

The purpose of creating this game was purely educational. I tried to use a lot of design patterns and follow object-oriented design principles, even if some of them weren't necessary in this small project.

Pixel art by me.

## Used Design Patterns
  1. State - altering between game screens, such as Main Menu, Settings etc. In the Game class, methods such as `render()`, `dispose()`, `resize()` delegate state-related work to current game screen.
  2. Singleton - ensuring only one instance of Player class and providing global access to it.
  3. Template method - skeleton of algorithm in `render()` method - used in abstract class GameScreenState, subclasses override some steps.
  4. Composite - composing drawable objects (graphics) into tree structure, all of them are implementing same interface, so we can call `draw()` and `update()` methods on whole tree.
  5. Prototype - used in spawning Vehicles on Road, radomly producing clones of generic prototypes in prototype registry (VehicleRegitry class, Vehicle has `clone()` method).
  6. Command - encapsulating commands, such as moving Player, allowing to easily change some controls in settings.
  7. Decorator - attaching new behavior to DrawableCommand in CommandDecorator class. Used in implementing drawable menu buttons.
  8. Adapter - used in CommandAdapter. Decided to use Adapter instead of time-consuming rewriting some parts of Command related code.
  9. Strategy - family of interchangeable driving algorithms for Vehicle objects.
  10. Observer - Road (Observable) is notyfing Vehicles (Observer) about certain evens, allowing Vehicles to change their behavior. 
  11. Flyweight - all instances of MovingSnowflake class share common parts as reference to the model object of Snowflake.
  12. (Null Object - used in NullCommand - calling `execute()` that will do nothing, instead of checking if command is null)
  
## Screenshots
  ![Main Menu](https://i.ibb.co/72dq2rG/in-menu1.png)
  ![Settings](https://i.ibb.co/LdJfJms/in-menu2.png)
  ![In Game](https://i.ibb.co/Qn6rbNb/in-game1.png)
  ![Level Up](https://i.ibb.co/fXR0Nd7/in-game2.png)

