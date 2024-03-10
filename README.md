# Java Blackjack Training Bot

A simple Java program that simulates Blackjack hands. It uses a basic reinforcement learning algorithm where the bot decides whether to hit or stand based on past wins, adjusting its decisions over time.

## Getting Started

### Prerequisites

- Java installed on your machine.

### Installation

1. Clone the repo:
git clone https://github.com/yourusername/java-blackjack-bot.git

2. Navigate to the project directory:
cd BlackJackAI

3. Compile the Java files:
javac Bot.java BlackJackTrainer.java

### Usage

Run the program with:
java BlackJackTrainer

The bot will train itself over a default number of hands, which you can adjust in the source code.

## About The Project

The bot starts with a 50/50 chance of hitting or standing. As it plays, it slightly adjusts these chances based on whether it wins or loses, simulating a very basic form of learning.

## Contributing

Feel free to fork the project, make changes, and submit a pull request if you have ideas for improvements!


