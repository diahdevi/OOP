#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <ctype.h>

#define SIZE 100

struct Data
{
    char id[10];
    char name[100];
    char number[20];
    int age;
    char type[15];
    int duration;
    struct Data *next;
    struct Data *prev;
} *arr[SIZE];

Data *create(char name[], char number[], int age, char type[], int duration, char id[])
{
    Data *newData = (Data *)malloc(sizeof(Data));
    strcpy(newData->name, name);
    strcpy(newData->number, number);
    newData->age = age;
    strcpy(newData->type, type);
    newData->duration = duration;
    newData->next = NULL;
    return newData;
}

bool validPhone(char phone[20])
{
    if (strncmp(phone, "+62", 3) == 0)
        return 1;
    return 0;
}

int key(char id[])
{
    int sum = 0;
    sum = (id[2] - '0') + (id[3] - '0') + (id[4] - '0') - 1;
    return sum % SIZE;
}

void enter()
{
    printf("Press ENTER to continue...");
    getchar();
}

void booking()
{
    char id[20];
    char name[100];
    char number[20];
    int age;
    char type[15];
    int duration;
    bool valid;

    do
    {
        printf("Input Full Name [3..30] : ");
        scanf("%[^\n]", name);
        getchar();
        printf("Full name length must between 3 and 30\n");
    } while (strlen(name) < 3 || strlen(name) > 30);
    do
    {
        printf("Input Phone Number : ");
        scanf("%[^\n]", number);
        getchar();
        valid = validPhone(number);
    } while (valid == 0);
    do
    {
        printf("Input Age : ");
        scanf("%d", &age);
        getchar();
    } while (age < 18);
    do
    {
        printf("Input Type : ");
        scanf("%[^\n]", type);
        getchar();
    } while (strcmp(type, "Regular") != 0 &&
             strcmp(type, "Deluxe") != 0 &&
             strcmp(type, "Suite") != 0);
    do
    {
        printf("Input Duration : ");
        scanf("%d", &duration);
        getchar();
    } while (duration < 1 || duration > 30);

    sprintf(id, "%c%c%d%d%d", toupper(type[0]), toupper(type[1]), rand() % 10, rand() % 10, rand() % 10);

    Data *newData = create(name, number, age, type, duration, id);

    int index = key(id);

    if (arr[index] == NULL)
    {
        arr[index] = newData;
        return;
    }

    Data *temp = arr[index];
    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = newData;
}

void view()
{
    int count = 1;
    for (int i = 0; i < SIZE; i++)
    {
        Data *temp = arr[i];
        if (temp)
            count = 0;
        while (temp)
        {
            printf("ID : %s\n", temp->id);
            printf("Full Name : %s\n", temp->name);
            printf("Phone Number : %s\n", temp->number);
            printf("Room Type : %s\n", temp->type);
            printf("Night Stay : %s\n", temp->duration);
            temp = temp->next;
        }
    }

    if (count)
    {
        printf("There is no booking !\n");
    }
}

void del()
{
    int count = 1;

    for (int i = 0; i < SIZE; i++)
    {
        Data *temp = arr[i];
        if (temp)
        {
            count = 0;
            break;
        }
    }

    if (count)
    {
        printf("There is no booking !\n");
        return;
    }
    char id[10];

    printf("Input Bookign ID (Case Sensitive) : ");
    scanf("%[^\n]", id);
    int index = key(id);

    Data *temp = arr[index];

    if (arr[index] == NULL)
    {
        printf("Not Found\n");
        return;
    }
    else if (strcmp(temp->id, id) == 0)
    {
        temp = NULL;
        free(temp);
        return;
    }
    else
    {
        while (temp != NULL && strcmp(temp->next->id, id) != 0)
        {
            temp = temp->next;
        }
        Data *pop = temp->next;
        temp->next = pop->next;
        free(pop);
        return;
    }

    puts("Data not found");
}

int main()
{
    int input;
    do
    {
        printf("Hotel GrAnsylvania\n");
        printf("1. Booking Hotel\n");
        printf("2. View Bookings\n");
        printf("3. Delete Bookings\n");
        printf("4. Exit\n");
        printf(">>");
        scanf("%d", &input);

        switch (input)
        {
        case 1:
            booking();
            break;
        case 2:
            view();
            break;
        case 3:
            del();
            break;
        }
    } while (input >= 1 && input <= 3);
    return 0;
}