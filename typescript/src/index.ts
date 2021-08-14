const name = "Sangjin",
    age = 34,
    gender = "male";

const sayHi = (name: string, age: number, gender?: string) => {
    console.log(`${name} is ${age} and ${gender}!`)
}

sayHi(name, age, gender)

export {}
