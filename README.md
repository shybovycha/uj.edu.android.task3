# Programowanie Android. Zadanie #3

## Credits

Mobile Devices Programming - Android
Jagiellonian University, Institute of Computer Science, 2014

**Task:** Przemysław Kadela

**Solution:** Artem Shoobovych

**Workshop:** (3) 2014-03-12


## Topics

* Using Intents to start the activity

## Assignements

### Pizza ordering

Create Android SDK application for placing orders for pizza. The UI consists of four screens (1) to (4).

* *Screen (1): Pizza selection*
	The user selects one from at least three kinds of pizza. Types of pizza are presented in form of pictures with text labels.
	Each type of pizza has different price.
	Whe the user clicks chosen picture, the choice is recorded and the user is moved to screen (2).
* *Screen (2): Extras*
	The user can check zero or more extra things for his order.
	The extras are:
	- xxl version (+40% of initial price)
	- extra cheese (+5% of initial price)
	- express service (+10% of initial price)
	Button Next is visible at the bottom of the screen. After clicking it the user is redirected to screen (3) with his choice recorded. 
* *Screen (3): Comment*
	The user can enter his final comments to the order. The comments are in form of text field.
	Button Next is visible at the bottom of the screen. After clicking it the user is redirected to screen (4) with his comments recorded. 
* *Screen (4): Summary*
	The user is informed about his choices and pricing (calculations and total).
	There are two buttons on the screen:
	- Order : shows Toast information the the order has been sent and button blocks at this moment
	- Reset : redirects the user back to screen (1) with all choices records deleted. After the Reset is pressed and the user is back on (1) and presses Back button the application should exit.

