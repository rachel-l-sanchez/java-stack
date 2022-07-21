from flask import Flask, render_template
app = Flask (__name__) # new instance of Flask class
 
@app.route("/") 
def index():
    return "Hello World!"
 
@app.route('/success')
def success():
    return "Success"

@app.route('/hello/<string: banana>/<int:num>')
def hello(banana, num):
    return render_template('hello: html'banana=banana, num=num)

@app.route('/lists')
def render_lists():
    basketball_players = [
        {'name': 'Blake', 'age': 35}
        {'name': 'Michael', 'age': 38}
        {'name': 'Shaq', 'age': 33}
    ]
    return render_templates("lists.html", random_numbers=[1,3,5], basketball= basketball_players)

if __name__=="__main__":
    app.run(debug=True)
   