# GitHub User Activity

Use GitHub API to fetch user activity and display it in the terminal.

In this project, you will build a simple command line interface (CLI) to fetch the recent activity of a GitHub user and display it in the terminal. This project will help you practice your programming skills, including working with APIs, handling JSON data, and building a simple CLI application.

## Requirements

The application should run from the command line, accept the GitHub username as an argument, fetch the user’s recent activity using the GitHub API, and display it in the terminal. The user should be able to:

- Provide the GitHub username as an argument when running the CLI.

  ```bash
  github-activity <username>
  ```
- Fetch the recent activity of the specified GitHub user using the GitHub API. You can use the following endpoint to fetch the user’s activity:

  ```bash
  # https://api.github.com/users/<username>/events
  # Example: https://api.github.com/users/kamranahmedse/events
  ```

- Display the fetched activity in the terminal
  ```bash
  Output:
  - Pushed 3 commits to kamranahmedse/developer-roadmap
  - Opened a new issue in kamranahmedse/developer-roadmap
  - Starred kamranahmedse/developer-roadmap
  - ...
  ```
  You can [learn more about the GitHub API here](https://docs.github.com/en/rest/activity/events?apiVersion=2022-11-28).
- Handle errors gracefully, such as invalid usernames or API failures.
- Use a programming language of your choice to build this project. 
- Do not use any external libraries or frameworks to fetch the GitHub activity.

If you are looking to build a more advanced version of this project, you can consider adding features like filtering the activity by event type, displaying the activity in a more structured format, or caching the fetched data to improve performance. You can also explore other endpoints of the GitHub API to fetch additional information about the user or their repositories.

the instruction was created by [roadmap.sh](https://roadmap.sh/projects/github-user-activity)

# Solution

This project is built using **Java**, **Spring Boot**, **Spring Shell**, and **RestTemplate**. The command-line interface (CLI) allows users to fetch recent activity from any GitHub account by simply providing a username. The project demonstrates how to interact with the GitHub API, process JSON responses, and display the results in a user-friendly format directly in the terminal.

### Key Features:

1. **Fetch GitHub User Activity**:
  - The CLI accepts a GitHub username as an argument and retrieves the user's recent activity from the GitHub API using the endpoint:

    ```bash
    https://api.github.com/users/<username>/events
    ```

  - The user can invoke the CLI with the command:

    ```bash
    github-activity <username>
    ```

  - This will display the user's recent activities in the terminal, such as:
    - Pushing commits
    - Opening issues
    - Starring repositories
    - And more...

2. **Error Handling**:
  - The CLI handles errors gracefully, such as:
    - Invalid GitHub usernames (e.g., displaying a message when the username does not exist).
    - API request failures (e.g., due to network issues or rate limits imposed by GitHub).

3. **Activity Limit Feature**:
  - In addition to the core functionality, a new feature has been added to allow users to limit the number of activities displayed. This can be useful when only the most recent activities are of interest.
  - The command to use this functionality is:

    ```bash
    github-activity-limit <username> <limit>
    ```

  - This will restrict the output to the specified number of events, improving readability and allowing users to focus on the most relevant activities.

4. **API Interaction**:
  - The project uses **RestTemplate** to make API requests to GitHub, fetching data in JSON format. The data is then parsed and displayed in the terminal with relevant information like commit messages, repository names, and actions performed.

5. **Command-Line Interface**:
  - Built with **Spring Shell**, the CLI is designed to be simple, responsive, and easy to use. Users can quickly fetch and limit activity information by just running the appropriate commands.

### Technologies Used:

- **Java**: The main programming language for the application.
- **Spring Boot**: To structure the project and handle dependencies.
- **Spring Shell**: To implement the command-line interface.
- **RestTemplate**: To fetch data from the GitHub API.

### Future Enhancements:

- **Filtering by Event Type**: The ability to filter activities by type (e.g., only show commits or issues).
- **Caching**: Implementing a caching mechanism to reduce API requests and improve performance.
- **More Detailed Output**: Providing additional information about each event, such as timestamps or detailed descriptions of each action.

This solution provides a solid foundation for interacting with GitHub's API and displaying user activity via a CLI. The added functionality for limiting the number of displayed activities makes the application more user-friendly and efficient.


