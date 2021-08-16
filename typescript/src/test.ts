interface Human {
    name : string,
    age: number,
    gender: string
}

//use class 
class HumanClass {
    public name: string
    public age: number
    public gender: string

    constructor(name: string, age:number, gender:string){
        this.name = name
        this.age = age
        this.gender = gender
    }
}

// use interface
const person = {
    name : 'Me',
    age: 11,
    gender: 'female'
}

//use class
const S = new HumanClass('SSS', 126, 'male')

const name = "Sangjin",
    age = 34,
    gender = "male";

const sayHi = (name: string, age: number, gender?: string) => {
    console.log(`${name} is ${age} and ${gender}!`)
}

// use interface
const sayBye = (person: Human) => {
    console.log(`${person.name} is ${person.age} and ${person.gender}!!!`)
}

//use class
const sayClass = (person: HumanClass) => {
    console.log(`${person.name} is ${person.age} and ${person.gender}!!!`)
}

sayHi(name, age, gender)
sayBye(person)
sayClass(S)


export {}
