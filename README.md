# Product Spec Design

### App Overview

FoodForYou is designed to allow people to search for plethoras of cuisines and recipes. The app's base implementation allows the user to explore a random feed of recipes or to specifically search by name or list of ingredients. Users will also be able to view descriptions of the recipes they deem interesting and can explore detailed information regarding their time to cook, required ingredients, nutritional facts, and more.

## 1. Stories
- **User Stories (Required for MVP)**
  - [ ] Search Bar
  - [ ] Search for a recipe by category / specific keywords / ingredients
  - [ ] Selecting recipes from search list
  - [ ] Viewing description pages of selected recipes
  - [x] Bottom Navigation Tabs

- **Optional Stories (Optional Features)**
  * Login page
  * Input account details
  * View account info (a page)
  * Sort by popularity feature
  * Additional recipe facts (ie. nutrition, graphs, videos) displayed
  * Recents page
  * Infinite pagination
  * Popularity/trending page
  
## 2. Screen Archetypes
- Login screen (stretch goal)
  * User opens app to log in or sign up
- Registration page (stretch goal)
  * Further registration info for user to fill out
- Popularity Stream
  * User can view list of popular recipes
- Recents Stream
  * User can view list of recently created recipes
- Search
  * User can enter detail keywords/categories to search
  
## 3. Navigation
- Main screen
  * Divided into 3 main tabs
- Popularity stream
  * left-most, default tab
- Recents stream
- Search tab
  * displays options list ==> detailed page
- Login page (stretch)
  * ==> flows into default tab after completion


## Priorities

popularity / recents page - more challenging
 - not based on current user send
 - local file system to save 
 - to-do app
 - recommendations (machine learning part).....
  - api fetches recommendations for us
  - github recommendations to get
  
  
**Order of what to do:**
- Search bar on top
- Retrieving and displaying the list
 * selecting takes you to details page

- sort by feature on search bar
- at the end, clean up visuals
- List food
 * Filters after we can retrieve/display the lists of recipe results
 
 
 filters: min/maxsugar - min/maxcalories
 
 url for recipe for extraction of info:
 - GET https://api.spoonacular.com/recipes/extract

Video results will be a stretch goal

----------
# Figma Wireframe

![](/figmaFinalization.PNG)

# Extra Sketches

![](/Figma-Sketches.PNG)

-----------
## Models

| Property    | Type        | Description |
| ----------- | ----------- | ----------- |
| description | String      | description of searched recipes |
| instruction | String      | instructional text for creating meal |
| ingredients | String      | list of ingredients for recipe |
| authorId    | String      | Name of user who create recipe |
| makeTime    | int         | Amount of time required to create meal |
| recipeName  | String      | Recipe name |
| cuisine     | String      | Type of cuisine (iee. culture origin) |
| ... | ... | ... |

-----------

## Network

- Search Screen Feed
  - (Read/GET) Query the user search in search tab and return list of results
- Detail Screen
  - (Read/GET) Query specific result and display deeper information
- Explore Screen Feed
  - (Read/GET) Populate with feed of random list of recipes

| Method            | Example          |
| ----------------- | ---------------- |
| Query user input  | Fetching recipes |

Reference links for API:
https://spoonacular.com/food-api/docs
https://spoonacular.com/food-api/docs#Show-Images
## API Endpoints

| HTTP Verb   | Endpoint    | Description |
| ----------- | ----------- | ----------- |
| ```GET```   | /includeIngredients | Comma-separated list of ingredients |
| ```GET```   | /author | Username of recipe author |
| ```GET```   | /minCalories + /maxCalories | Calories of searched recipe |
| ```GET```   | /maxReadyTime | Time required to prepare recipe |
| ```GET```   | /maxSaturatedFat | Additional info; fat info per recipe |
| ```GET```   | /cuisine | Retrieve detail of culture for dish (ie. italian, chinese, etc. |
| ... | ... | ... |
