# Hypocrypt

Hypocrypt is an information security challenge in the Crypto category, and was presented to participants of [KAF CTF 2019](https://ctf.kipodafterfree.com)                       

## Challenge story

Well, you can say is is a secret, but is is really encrypted?

## Challenge exploit

Key bruteforce & reversal after knowing the expected output.

## Challenge solution

## Building and installing

[Clone](https://github.com/NadavTasher/2020-Hypocrypt/archive/master.zip) the repository, then type the following command to build the container:
```bash
docker build . -t hypocrypt
```

To run the challenge, execute the following command:
```bash
docker run --rm -d -p 1140:8000 hypocrypt
```

## Usage

You may now access the challenge interface through: `nc localhost 1140`

## Flag

Flag is:
```flagscript
KAF{v3ri_n0ic3_oss_ftw}
```

## License
[MIT License](https://choosealicense.com/licenses/mit/)