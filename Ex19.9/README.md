# Exercise 19.9

This project is the solution to Exercise 19.9

## Example Output

![Sample Output](README.jpg)

## Analysis Steps

The exercise was to write the following method that sorts an ArrayList:

```
public static <E extends Comparable<E>> void sort(ArrayList<E> list)
```
  
I created a series of ArrayLists for Integer, Double, Character, and String and then printed them to demonstrate the order they are in. Using the method defined in the book, I then implimented Collections to perform the sort. Finally, I print the newly sorted ArrayLists to demonstrate that they are properly sorted.

### Design

Exercise 19.8 served to demonstrate to me the pitfalls of attempting to impliment an algorithm to perform a task in lieu of leaning on an existing Class such as Collections to do the work. This made Exercise 19.9 as simple as implimenting sort instead of shuffle.

### Testing

Does the program compile?

```
Pass
```

Does the program display the ArrayLists before sorting appropriately?

```
Pass
```

Does the program display the ArrayLists appropriately after sorting?

```
Pass
```

## Notes

Explain any issues or testing instructions.

## Do not change content below this line
## Adapted from a README Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
