class Block {
    public index:number
    public hash:string
    public previousHash:string
    public data:string
    public timestamp:number

    constructor(index: number, hash:string, previousHash:string, data:string, timestamp:number){
        this.index = index
        this.data = data
        this.hash = hash
        this.previousHash = previousHash
        this.timestamp = timestamp
    }
}

const genericBlock:Block = new Block(0, "20202020202", "", "hello", 123456)

let blockChain:[Block] = [genericBlock]

console.log(blockChain)