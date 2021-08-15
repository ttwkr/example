interface Human {
    name : string,
    age: number,
    gender: string
}

const person = {
    name : 'Me',
    age: 11,
    gender: 'female'
}

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

sayHi(name, age, gender)
sayBye(person)

export {}
