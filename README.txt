
    so the plan is to make some kind of "new tab" thing

    something like, you get served a webpage with a funky gradient based on the time, and friendly quote, maybe some weather

    and some user configurable settings like dark mode, choose gradient based on weather or time or fav color (so we have POST to the api)

    if I get time and all goes well ill add some kind of idle game ish nonsense too because why not.

    lets make a roadmap

        - ~~get this all on git + figure out gitignore~~ sorted
        - ~~do a bit of TDD action for a quote generator (author, quotes, gradient)~~ sorted
        - ~~similar for some kinda of data scaffolding. We wont have a proper db, only in memory stuff,
            so reading and deserializing a json file in maybe?~~ we ended up just reading them in in the web controller constructor. Simplest solution given the time remaining.
        -